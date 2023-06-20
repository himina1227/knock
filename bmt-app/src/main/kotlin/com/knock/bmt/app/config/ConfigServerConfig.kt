package com.knock.bmt.app.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Component


@Component
@RefreshScope // 설정 정보가 바뀌면 refresh -> git 주소에 있는 설정 파일을 수정했을시 /actuator/refresh
class ConfigServerConfig {

}