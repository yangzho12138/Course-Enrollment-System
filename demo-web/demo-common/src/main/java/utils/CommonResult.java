package utils;

/*
Author: Yang Zhou
Date: 2022-6-26
Description: Return Object
 */

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    public Integer code; // 1 - success, 0 - failed
    public String message;
    public T data;

    public CommonResult(Integer code, String message){
        this.code=code;
        this.message=message;
        this.data=null;
    }
}
