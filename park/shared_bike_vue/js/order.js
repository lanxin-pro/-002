import { get, post, put } from '../request.js'

const baseUrl = '/bigtian/order'

export default {
    // 获取订单列表
    list(params) {
        return get(`${baseUrl}/list`, params)
    },
    
    // 获取用户订单列表
    getUserOrders(userId) {
        return get(`${baseUrl}/user/${userId}`)
    },
    
    // 获取订单详情
    getDetail(orderId) {
        return get(`${baseUrl}/${orderId}`)
    },
    
    // 更新订单状态
    updateStatus(orderId, status) {
        return put(`${baseUrl}/${orderId}/status`, { status })
    }
} 