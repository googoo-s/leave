package org.example.types.leave.ro;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLeaveRo {
    private Integer applicantId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;
    private String content;
}
