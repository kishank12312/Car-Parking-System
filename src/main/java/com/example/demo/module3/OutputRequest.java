package com.example.demo.module3;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class OutputRequest {
    private final String whichButton;
    private final String name;
    private final String hrs;
    private final String rating;

}
