package org.example.types.leave.ro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLeaveRo {
    private Integer applicantId;
    private LocalDate startTime;
    private LocalDate endTime;
    private String content;
}
