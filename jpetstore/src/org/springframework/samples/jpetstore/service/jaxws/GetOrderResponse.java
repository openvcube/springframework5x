
package org.springframework.samples.jpetstore.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getOrderResponse", namespace = "http://service.jpetstore.samples.springframework.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrderResponse", namespace = "http://service.jpetstore.samples.springframework.org/")
public class GetOrderResponse {

    @XmlElement(name = "return", namespace = "")
    private org.springframework.samples.jpetstore.domain.Order _return;

    /**
     * 
     * @return
     *     returns Order
     */
    public org.springframework.samples.jpetstore.domain.Order getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(org.springframework.samples.jpetstore.domain.Order _return) {
        this._return = _return;
    }

}
