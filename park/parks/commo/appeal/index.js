import { post } from '../request.js'

// 调用后台申诉接口，端口为8181
const baseUrl = 'http://localhost:8181/appeal'

export default {
  add(data) {
    return post(`${baseUrl}/add`, data)
  }
}
