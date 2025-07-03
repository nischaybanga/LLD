package com.lld.lowleveldesign.snakeAndLadder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jumpers {
    private Integer start;
    private Integer end;

    public Integer getEnd() {
        return end;
    }
}
