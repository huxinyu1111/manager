<template>
  <div class="container">
    <div style="width: 400px; padding: 30px; background-color: rgba(255,255,255,0.5); border-radius: 20px;">
      <div style="text-align: center; font-size: 20px; margin-bottom: 20px; color: #333">欢迎注册</div>
      <el-form :model="form" :rules="rules" ref="formRef">
        <el-form-item prop="username">
          <el-input prefix-icon="el-icon-user" placeholder="请输入账号" v-model="form.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input prefix-icon="el-icon-lock" placeholder="请输入密码" show-password  v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPass">
          <el-input prefix-icon="el-icon-lock" placeholder="请确认密码" show-password  v-model="form.confirmPass"></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="form.role" placeholder="请选择角色" style="width: 100%">
            <el-option label="商家" value="BUSINESS"></el-option>
            <el-option label="用户" value="USER"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%; background-color: #333; border-color: #333; color: white" @click="register">注 册</el-button>
        </el-form-item>
        <div style="display: flex; align-items: center">
          <div style="flex: 1"></div>
          <div style="flex: 1; text-align: right">
            已有账号？请 <a href="/login">登录</a>
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
  name: "Register",
  data() {
    // 验证码校验
    const validatePassword = (rule, confirmPass, callback) => {
      if (confirmPass === '') {
        callback(new Error('请确认密码'))
      } else if (confirmPass !== this.form.password) {
        callback(new Error('两次输入的密码不一致'))
      } else {
        callback()
      }
    }
    return {
      form: {},
      rules: {
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        confirmPass: [
          { validator: validatePassword, trigger: 'blur' }
        ]
      }
    }
  },
  created() {

  },
  methods: {
    register() {
      this.$refs['formRef'].validate((valid) => {
        if (valid) {
          // 验证通过
          this.$request.post('/register', this.form).then(res => {
            if (res.code === '200') {
              this.$router.push('/')  // 跳转登录页面
              this.$message.success('注册成功')
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
  background: linear-gradient(200deg, #a8e1e8, #a9edc4);
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