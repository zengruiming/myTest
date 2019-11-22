package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private boolean flag;
    private Integer code;
    private String message;
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
