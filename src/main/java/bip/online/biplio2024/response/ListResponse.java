package bip.online.biplio2024.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ListResponse<T> extends BaseResponse {
    private List<T> data;

    public ListResponse (boolean success, String message, List<T> data) {
        super(success, message);
        this.data = data;
    }}

