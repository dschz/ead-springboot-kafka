package com.dsc.frm.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DSchneider
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String msg;
    private String status;
    private Order order;
}
