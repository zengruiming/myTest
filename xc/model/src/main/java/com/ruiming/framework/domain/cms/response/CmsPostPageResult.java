package com.ruiming.framework.domain.cms.response;

import com.ruiming.framework.model.response.ResponseResult;
import com.ruiming.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @version 1.0
 **/
@Data
@NoArgsConstructor
public class CmsPostPageResult extends ResponseResult {

    String pageUrl;
    public CmsPostPageResult(ResultCode resultCode, String pageUrl) {
        super(resultCode);
        this.pageUrl = pageUrl;
    }
}
