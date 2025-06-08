<template>
  <div class="map-container">
    <div id="container"></div>
  </div>
</template>

<script setup name="Index">
import { onMounted, ref } from 'vue'

const version = ref('3.8.2')
const map = ref(null)

onMounted(() => {
  initMap()
})

function initMap() {
  map.value = new BMap.Map("container")

  // 创建地理位置实例
  const geolocation = new BMap.Geolocation()

  // 获取当前位置
  geolocation.getCurrentPosition(function(r) {
    if (this.getStatus() == BMAP_STATUS_SUCCESS) {
      const point = r.point
      map.value.centerAndZoom(point, 18)

      // 添加标记
      const marker = new BMap.Marker(point)
      map.value.addOverlay(marker)

    } else {
      // 如果获取失败，使用默认坐标
      const defaultPoint = new BMap.Point(108.93, 34.27)
      map.value.centerAndZoom(defaultPoint, 18)
      console.warn('failed to get location: ' + this.getStatus())
    }
  })

  // 开启鼠标滚轮缩放
  map.value.enableScrollWheelZoom(true)
}

function goTarget(url) {
  window.open(url, '__blank')
}
</script>

<style scoped lang="scss">
.map-container {
  width: 90%;
  height: 90%;
}
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}

.map-container {
  width: 100%;
  height: 100vh;
  
  #container {
    width: 100%;
    height: 100%;
  }
}
</style>

