package com.bittereggs.admin1_8010.utils;

import com.bittereggs.admin1_8010.entity.Order;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 楼中煊
 * @data 2019/4/5
 * @time 16:28
 */

public class FormatData {

    public String formatorder(JSONArray data){
        JSONArray result = new JSONArray();
        Order temp;
        for (int i = 0; i < data.size(); i++){
            temp = (Order) JSONObject.toBean(JSONObject.fromObject(data.get(i)),Order.class);
            result.add(order(temp));
        }
        return result.toString();
    }

    private JSONArray order(Order order){
        List<String> phase_name = list(order.getPhase_name());
        List<String> phase_price = list(order.getPhase_price());
        List<String> pay_state = list(order.getPay_state());
        List<Order> list = new ArrayList<>();
        for (int i = 0; i < phase_name.size(); i++){
            Order temp = new
                    Order(order.getOrder_id(),phase_name.get(i),order.getEnterprise_name(),phase_price.get(i),pay_state.get(i));
            list.add(temp);
        }
        JSONArray result = JSONArray.fromObject(list);
        return result;
    }

    public List<String> list(String string){
        List<String> list = new ArrayList<>();
        for (int i = 0,s=string.length(); i < s;){
            if (string.charAt(i) == '/'){
                list.add(string.substring(0,i));
                string = string.substring(i+1);
                s = string.length();
                i=0;
            } else {
                i++;
            }
        }
        return list;
    }

    public Order remakeOrder(Order old, Order update){
        //old原本数据，update要修改的数据
        Order order = old;
        //判断更新的是哪条数据
        List<String> phase_name = list(old.getPhase_name());
        List<String> pay_state = list(old.getPay_state());
        int chage = 0;
        String state = null;
        for (int i = 0; i < phase_name.size(); i++){
            if (phase_name.get(i).equals(update.getPhase_name())){
                //查询出修改的是第几条数据
                chage = i;
                break;
            }
        }
       pay_state.set(chage,update.getPay_state());
        for (int i = 0; i < pay_state.size(); i++){
            if (i != 0)
                state = state + pay_state.get(i) + "/";
            else {
                state = pay_state.get(i) + "/";
            }
        }
        order.setPay_state(state);
        return order;
    }
}
