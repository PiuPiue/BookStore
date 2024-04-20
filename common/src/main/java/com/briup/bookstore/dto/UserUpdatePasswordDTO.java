package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author briup-adam
 * @Date 2023/7/26 下午2:37
 * @Description 用户修改密码传输对象
 **/

@Data
@ApiModel("用户修改密码传输对象")
@Accessors(chain = true)
public class UserUpdatePasswordDTO {
    @ApiModelProperty("旧密码")
    private String oldPassword;
    @ApiModelProperty("新密码")
    private String newPassword;
}
