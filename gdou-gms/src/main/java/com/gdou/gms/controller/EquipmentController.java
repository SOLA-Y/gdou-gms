package com.gdou.gms.controller;

import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.EquOrder;
import com.gdou.gms.pojo.Equipment;
import com.gdou.gms.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EquipmentController
{
    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/addEquipment")
    public Boolean addEquipment(@RequestBody Equipment equipment)
    {
        return equipmentService.addEquipment(equipment);
    }

    @GetMapping("/deleteEquipment")
    public Boolean deleteEquipment(@RequestParam("equId") Integer equId)
    {
        return equipmentService.deleteEquipment(equId);
    }

    @GetMapping("/queryEquipment")
    public Equipment queryEquipment(@RequestParam("equId") Integer equId)
    {
        return equipmentService.queryEquipment(equId);
    }

    @GetMapping("/queryAllEquipments")
    public List<Equipment> queryAllEquipments()
    {
        return equipmentService.queryAllEquipments();
    }

    @PostMapping("/queryEqusByCondition")
    public List<Equipment> queryEqusByCondition(@RequestBody Condition condition)
    {
        return equipmentService.queryEquipmentsByCondition(condition);
    }

    @PostMapping("/updateEquipment")
    public Boolean updateEquipment(@RequestBody Equipment equipment)
    {
        return equipmentService.updateEquipment(equipment);
    }

    @PostMapping("/addEquOrder")
    public Boolean addEquOrder(@RequestBody EquOrder equOrder)
    {
        return equipmentService.addEquOrder(equOrder);
    }

    // 添加器材维修订单
    @GetMapping("/repairEquipment")
    public Boolean repairEquipment(@RequestBody EquOrder equOrder)
    {
        return equipmentService.repairEquipment(equOrder);
    }

    @GetMapping("/deleteEquOrder")
    public Boolean deleteEquOrder(@RequestParam("equOrderId") Integer equOrderId)
    {
        return equipmentService.deleteEquOrder(equOrderId);
    }

    @GetMapping("/queryEquOrder")
    public EquOrder queryEquOrder(@RequestParam("equOrderId") Integer equOrderId)
    {
        return equipmentService.queryEquOrder(equOrderId);
    }

    @GetMapping("/queryAllEquOrders")
    public List<EquOrder> queryAllEquOrders()
    {
        return equipmentService.queryAllEquOrders();
    }

    @PostMapping("/queryEquOrdersByCondition")
    public List<EquOrder> queryEquOrdersByCondition(@RequestBody Condition condition)
    {
        return equipmentService.queryEquOrdersByCondition(condition);
    }

    @GetMapping("/queryEquOrdersByCondition")
    public List<EquOrder> queryEquOrdersByUserId(@RequestParam("userId") String userId)
    {
        return equipmentService.queryEquOrdersByUserId(userId);
    }

    // 器材预约审核通过
    @GetMapping("/verifiedEquOrder")
    public Boolean verifiedEquOrder(@RequestParam("equOrderId") Integer equOrderId)
    {
        return equipmentService.verifiedEquOrder(equOrderId);
    }

    // 器材归还（器材申请归还或器材维修完成）
    @GetMapping("/returnEquipment")
    public Boolean returnEquipment(@RequestParam("equOrderId") Integer equOrderId)
    {
        return equipmentService.returnEquipment(equOrderId);
    }


}
