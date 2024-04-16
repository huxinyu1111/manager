<template>
  <div class="main-content">

  </div>
</template>

<script>

export default {

  data() {
    let goodsId = this.$route.query.id
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      goodsId :goodsId,
      goodsData:{}
    }
  },
  mounted() {
    this.loadGoods()
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    loadGoods() {
      this.$request.get('/goods/selectById?id='+this.goodsId).then(res =>{
        if (res.code === '200'){
          this.goodsData = res.data
        }else{
          this.$message.error(res.msg)
        }
      })
    }
  }
}
</script>

