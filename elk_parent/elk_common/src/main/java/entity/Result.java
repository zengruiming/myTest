package entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @ApiModelProperty("成功/失败标识")
    private boolean flag;

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("消息")
    private String message;

    @ApiModelProperty("响应数据")
    private Object data;

    /**
     * @param flag:成功失败标记
     * @param code:状态码
     * @param message:消息
     * @Description:
     * @return:
     * @Author: zrm
     * @Date: 2019/11/18 18:06
     */
    public Result(boolean flag, Integer code, String message) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

}
