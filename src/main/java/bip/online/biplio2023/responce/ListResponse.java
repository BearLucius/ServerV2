package bip.online.biplio2023.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListResponse <T> extends  BaseResponse{

    private List<T> data;
    public ListResponse(boolean succes, String message, List<T> data){
        super(succes,message);
        this.data=data;
    }
}
