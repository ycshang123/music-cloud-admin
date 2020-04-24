package com.soft1851.music.admin.exception;

import com.soft1851.music.admin.common.ResultCode;

public class JwtException extends RuntimeException {
    protected ResultCode resultCode;

    public JwtException(String msg, ResultCode resultCode){
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
