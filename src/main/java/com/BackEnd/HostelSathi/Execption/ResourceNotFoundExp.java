package com.BackEnd.HostelSathi.Execption;

import lombok.extern.slf4j.Slf4j;


public class ResourceNotFoundExp extends RuntimeException {
    public ResourceNotFoundExp(String message) {
        super(message);
    }
}
