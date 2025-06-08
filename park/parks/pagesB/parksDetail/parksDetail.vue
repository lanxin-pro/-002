<template>
	<view>
		<tm-sheet :padding="[0,0]" flat>
			<h1 class="text-weight-b">{{ park.name }}</h1>
			<view class="flex flex-between">
				<view class="text-grey text-size-xs mt-10">
					<tm-icons name="icon-paper-plane" color="grey" />
					<span class="ml-10">{{ park.pointDetail }}</span>
				</view>
				<view> 
					<tm-tags size="xs" class="nowrap mr-10" color="red" model="text">价格：{{ park.price }}元/小时</tm-tags>
					<tm-tags size="xs" class="nowrap" :color="park.availableBikes > 0 ? 'green' : 'grey'" model="text">
						剩余车辆：{{ park.availableBikes || 0 }}
					</tm-tags>
				</view>
			</view>
		</tm-sheet>
		<tm-swiper :round="6" :margin="32" :autoplay="true" :indicator-dots="true" :list="list"></tm-swiper>
		<p class="ml-10 mb-20 mt-n10" style="height: 20px;">
			<tm-icons size="55" name="big-shuxian1" color="primary"></tm-icons>
			收费标准
		</p>
		<view class="text-grey" style="padding-bottom:60px;">
			<cu-editor v-if="showEditor" :readOnlys="true" :content="park.rates"></cu-editor>
		</view>
		<tm-sheet :margin="[16]" :round="3" :shadow="2">
			<view class="pa-24">
				<h3 class="text-weight-b mb-24">骑行信息</h3>
				
				<tm-input
					v-model="formData.destination"
					:placeholder="'请输入目的地'"
					:border="1"
					:round="3"
					class="mb-24"
					label="目的地"
				></tm-input>

				<tm-input
					v-model="formData.duration"
					:placeholder="'预计骑行时长（小时）'"
					:border="1"
					:round="3"
					type="number"
					class="mb-24"
					label="骑行时长"
				></tm-input>

				<view class="flex flex-row flex-between mt-24">
					<text class="text-grey">预计费用</text>
					<text class="text-red text-size-lg">¥{{ calculateCost }}</text>
				</view>
			</view>
		</tm-sheet>
		<view class="fixed fulled pb-25 white  shadow-grey-10" style="bottom: 0px;width: 100%;">
			<tm-sheet flat :padding="[0,0]">
				<view class="flex flex-between">
					<tm-button theme="bg-gradient-orange-accent" :round="4" @click="navigator">导 航</tm-button>
					<tm-button v-if="park.state === 'apply_success'" :round="4" @click="pay">确认骑行</tm-button>
				</view>
			</tm-sheet>
		</view>
		<tm-dialog v-model="show" :content="`确定支付${calculateCost}元吗？`" title='支付提示' @confirm='payOrder'></tm-dialog>
		<tm-message ref="toast"></tm-message>

	</view>
</template>

<script>
	import TmSheet from "../../tm-vuetify/components/tm-sheet/tm-sheet";
	import TmIcons from "../../tm-vuetify/components/tm-icons/tm-icons";
	import park from "../../commo/park";
	import payOrder from "../../commo/payOrder";
	import cuEditor from '@/components/cu-editor/cu-editor';
	import TmDivider from "../../tm-vuetify/components/tm-divider/tm-divider";

	export default {
		components: {
			TmDivider,
			TmIcons,
			TmSheet,
			cuEditor
		},
		data() {
			return {
				show: false,
				showEditor: false,
				list: [
					'https://picsum.photos/800?jv=34',
					'https://picsum.photos/800?jv=74',
					'https://picsum.photos/800?jv=3',
					'https://picsum.photos/800?jv=5'
				],
				park: {},
				formData: {
					destination: '',
					duration: ''
				}
			};
		},
		onLoad(e) {
			let than = this
			park.getById(e.id).then(res => {
				than.park = res.data
				than.list = res.data.atts.split(',')
				than.showEditor = true
			})
		},
		computed: {
			calculateCost() {
				if (!this.formData.duration || !this.park.price) return 0;
				return (parseFloat(this.formData.duration) * parseFloat(this.park.price)).toFixed(2);
			}
		},
		methods: {
			payOrder() {
				if (!this.formData.destination || !this.formData.duration) {
					this.$refs.toast.show({
						model: 'warning',
						label: '请填写完整的骑行信息'
					});
					return;
				}

				const data = {
					parkId: this.park.id,
					userId: "123",
					endPoint: this.formData.destination,
					duration: parseInt(this.formData.duration),
					estimatedCost: parseFloat(this.calculateCost)
				}
				
				let than = this;
				payOrder.save(data).then(res => {
					if (res.code === 200) {
						than.$refs.toast.show({
							model: 'success',
							label: '支付成功'
						});
						than.show = false; // 关闭支付确认弹窗
						than.loadParkDetail();
						// 清空表单
						than.formData.destination = '';
						than.formData.duration = '';
					} else {
						than.$refs.toast.show({
							model: 'error',
							label: res.msg || '创建订单失败'
						});
					}
				}).catch(err => {
					console.error('创建订单失败:', err);
					than.$refs.toast.show({
						model: 'error',
						label: '创建订单失败，请检查网络连接'
					});
				});
			},
			loadParkDetail() {
				let than = this;
				park.getById(this.park.id).then(res => {
					than.park = res.data;
					than.list = res.data.atts.split(',');
					than.showEditor = true;
				});
			},
			pay() {
				this.show = true
			},
			navigator() {
				uni.openLocation({
					latitude: parseFloat(this.park.latitude),
					longitude: parseFloat(this.park.longitude),
					name: this.park.name,
					address: this.park.name,
					scale: 28
				})
			}
		}
	};
</script>

<style scoped>
	/deep/ .cu-editor {
		padding-top: 0px !important;
		height: auto !important;
	}
</style>