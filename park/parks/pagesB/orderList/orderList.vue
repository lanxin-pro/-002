<template>
	<view>
                <view class="mt-10" v-for="item in data" :key="item.id" >
                        <tm-sheet :margin="[32, 20]" :round="6" :shadow="2">
                                <tm-row>
                                        <tm-col grid="3"><tm-images round="4" :height="200" model="aspectFill" :previmage="false"
                                                        :width="150" :src="item.picUrl"></tm-images></tm-col>
                                        <tm-col grid="9">
                                                <view class="text-align-left ml-20">
                                                        <view>
                                                                <span class="text-grey">支付人：{{item.nickName}}</span>
                                                        </view>
                                                        <view>
                                                                <span class="text-grey">停车场名称：{{item.parkName}}</span>
                                                        </view>
                                                        <view>
                                                                <span class="text-grey">支付金额：{{item.price}}</span>
                                                        </view>
                                                        <view>
                                                                <span class="text-grey">支付时间：{{item.createTime}}</span>
                                                        </view>
                                                        <view class="flex flex-row mt-10">
                                                                <tm-button size="s" :round="3" @click="toAppeal(item)">申诉</tm-button>
                                                                <tm-button size="s" :round="3" color="green" class="ml-20" @click="rideAgain(item)">再次骑行</tm-button>
                                                        </view>

                                                </view>
                                        </tm-col>
                                </tm-row>

                        </tm-sheet>
                </view>
	</view>
</template>

<script>
	import payOrder from "../../commo/payOrder";

	export default {
		data() {
			return {
				data: []
			}
		},
                mounted() {
                        const than = this
                        payOrder.list({}).then(res => {
                                than.data = res.rows
                        })
                },
                methods: {
                        toAppeal(item){
                                uni.navigateTo({
                                        url:`/pagesB/appeal/appeal?id=${item.id}`
                                })
                        },
                        rideAgain(item){
                                // 预留再次骑行功能，可跳转到停车场详情
                                uni.navigateTo({
                                        url:`/pagesB/parksDetail/parksDetail?id=${item.parkId}`
                                })
                        }
                }
        }
</script>

<style>

</style>