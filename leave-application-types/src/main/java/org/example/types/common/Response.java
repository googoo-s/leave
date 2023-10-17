package org.example.types.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private Status status;

    private String msg;

    private T data;

    public static Response<?> failed(String message) {
        return Response.builder().status(Status.FAILED).build();
    }

    public enum Status {
        SUCCESS, FAILED
    }

    public static <M> Response<M> ok() {
        return Response.<M>builder().status(Status.SUCCESS).build();
    }

    public static <M> Response<M> ok(String msg, M data) {
        return Response.<M>builder().status(Status.SUCCESS).data(data).msg(msg).build();
    }


    public static <M> Response<M> ok(M data) {
        return Response.<M>builder().status(Status.SUCCESS).data(data).build();
    }

}
