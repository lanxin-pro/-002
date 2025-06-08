<template>
  <view>
    <tm-message ref="toast"></tm-message>
    <tm-form @submit="submit">
      <tm-sheet :margin="[32,32]">
        <tm-input v-model="form.content" name="content" :height="120" input-type="textarea" placeholder="请输入申诉内容" required></tm-input>
        <view class="mt-24">
          <tm-button block navtie-type="form">提交申诉</tm-button>
        </view>
      </tm-sheet>
    </tm-form>
  </view>
</template>

<script>
import appeal from '@/commo/appeal'
export default {
  data(){
    return {
      form:{
        content:'',
        vid:null
      }
    }
  },
  onLoad(query){
    if(query && query.id){
      this.form.vid = query.id
    }
  },
  methods:{
    submit(e){
      if(e===false){
        this.$refs.toast.show({model:'warn',label:'请填写申诉内容'})
        return
      }
      appeal.add(this.form).then(res=>{
        if(res.code===200){
          this.$refs.toast.show({model:'success',label:'提交成功'})
          this.$back()
        }else{
          this.$refs.toast.show({model:'error',label:res.msg||'提交失败'})
        }
      })
    }
  }
}
</script>

<style>
</style>
