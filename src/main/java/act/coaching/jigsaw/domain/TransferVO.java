package act.coaching.jigsaw.domain;

import java.io.Serializable;
import java.util.List;



public class TransferVO implements Serializable{


    List<? extends Object> data;

    public TransferVO(){super();}

    public TransferVO(List<? extends Object> dataList){
        this.data = dataList;
    }


    public List<? extends Object> getData() {
        return data;
    }

    public void setData(List<? extends Object> data) {
        this.data = data;
    }



}
