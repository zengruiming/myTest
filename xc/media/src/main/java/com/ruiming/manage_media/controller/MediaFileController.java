package com.ruiming.manage_media.controller;

import com.ruiming.api.media.MediaFileControllerApi;
import com.ruiming.framework.domain.media.MediaFile;
import com.ruiming.framework.domain.media.request.QueryMediaFileRequest;
import com.ruiming.framework.model.response.QueryResponseResult;
import com.ruiming.manage_media.service.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/media/file")
public class MediaFileController implements MediaFileControllerApi {
    @Autowired
    MediaFileService mediaFileService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest) {
        return mediaFileService.findList(page,size,queryMediaFileRequest);
    }
}
