package com.toandd.project.thanhdat.common.util;

import com.toandd.project.thanhdat.common.dto.ResponseDTO;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

@UtilityClass
public class ResponseUtils {
    public static ResponseEntity<ResponseDTO> get(Object result, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(result)
                        .hasErrors(false)
                        .errors(Collections.emptyList())
                        .timeStamp(DateTimeUtils.now())
                        .build(),
                status
        );
    }
    public static ResponseEntity<ResponseDTO> error(RuntimeException runtimeException,HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(null)
                        .timeStamp(DateTimeUtils.now())
                        .build(),
                status
        );
    }
}
