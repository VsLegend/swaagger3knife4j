package com.example.swagger3knife4j.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Wang Junwei
 * @Date 2022/9/20 15:29
 * @Description
 */
@Data
@AllArgsConstructor
@Schema(description = "用户信息")
public class User {

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "电话")
    private String phone;

}
