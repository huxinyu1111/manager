<template>
  <div class="container">
    <div style="width: 400px; padding: 30px; background-color: rgba(255,255,255,0.5); border-radius: 20px;">
      <div style="text-align: center; font-size: 20px; margin-bottom: 20px; color: #333">欢迎登录兴安商城</div>
      <el-form :model="form" :rules="rules" ref="formRef">
        <el-form-item prop="username">
          <el-input prefix-icon="el-icon-user" placeholder="请输入账号" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input prefix-icon="el-icon-lock" placeholder="请输入密码" show-password  v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="form.role" placeholder="请选择角色" style="width: 100%">
            <el-option label="管理员" value="ADMIN"></el-option>
            <el-option label="商家" value="BUSINESS"></el-option>
            <el-option label="用户" value="USER"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%; background-color: #AF3939FF; border-color: #AF3939FF; color: white" @click="login">登 录</el-button>
        </el-form-item>
        <div style="display: flex; align-items: center">
          <div style="flex: 1"></div>
          <div style="flex: 1; text-align: right">
            还没有账号？请 <a href="/register">注册</a>
          </div>
        </div>
      </el-form>
    </div>
    <div class="box1">
    </div>
    <div class="box2">
    </div>
    <div class="box3">
    </div>
    <div class="box4">
    </div>
    <div class="box5">
    </div>
    <div class="box6">
    </div>


  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {},
      rules: {
        username: [{ required: true, message: '请输入账号', trigger: 'blur' },],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' },],
        role: [{ required: true, message: '请选择角色', trigger: 'blur' },],
      }
    }
  },
  created() {

  },
  methods: {
    login() {
      this.$refs['formRef'].validate((valid) => {
        if (valid) {
          // 验证通过
          this.$request.post('/login', this.form).then(res => {
            if (res.code === '200') {
              let user = res.data
              localStorage.setItem("xm-user", JSON.stringify(user))  // 存储用户数据
              if(user.role === 'USER'){
                location.href = '/front/home'
              }else {
                location.href = '/home'
              }
              this.$message.success('登录成功')
            } else {
              this.$message.error(res.msg)
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.container {
  height: 100vh;
  overflow: hidden;
  background: linear-gradient(200deg,#e3c5eb,#a9c1ed);
  background-size: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #666;
}
a {
  color: #2a60c9;
}
@keyframes myfist1 {
  0% {
    width: 0;
    height: 0;

    opacity: 1;
  }

  100% {
    width: 100px;
    height: 100px;
    opacity: 0;
  }
}

@keyframes myfist2 {
  0% {
    width: 0;
    height: 0;

    opacity: 1;
  }

  100% {
    width: 100px;
    height: 100px;
    opacity: 0;
  }
}
.box1,.box2,.box3,.box4,.box5,.box6 {
  width: 0px;
  height: 0px;
  position: fixed;
  border-radius: 50%;
  /* border: 1px solid rgb(250, 13, 13); */
  background-color: #fff;
  margin: 100px auto;
}
.box1 {
  left:100px;
  top: 0px;
  animation: myfist1 5s linear infinite;
}
.box2 {
  left:500px;
  top: 500px;
  animation: myfist2 7s linear infinite;
}
.box3 {
  left:100px;
  top: 1000px;
  animation: myfist1 5s linear infinite;
}
.box4 {
  left:2000px;
  top: 100px;
  animation: myfist1 5s linear infinite;
}
.box5 {
  left:1500px;
  top: 500px;
  animation: myfist1 8s linear infinite;
}
.box6 {
  left:2000px;
  top: 1000px;
  animation: myfist1 6s linear infinite;
}




</style>