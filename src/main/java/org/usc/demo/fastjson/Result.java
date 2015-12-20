package org.usc.demo.fastjson;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Shunli
 */
//@JSONType(serialzeFeatures = {})
public class Result {
    private int id;
    private ResultDetail detail;

    // private List<ResultDetail> details;

    public Result() {
    }

    public Result(int id, ResultDetail detail) {
        this.id = id;
        this.detail = detail;
    }

    // public Result(int id, List<ResultDetail> details) {
    // this.id = id;
    // this.details = details;
    // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    // public List<ResultDetail> getDetails() {
    // return details;
    // }
    //
    // public void setDetails(List<ResultDetail> details) {
    // this.details = details;
    // }

    public ResultDetail getDetail() {
        return detail;
    }

    public void setDetail(ResultDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
