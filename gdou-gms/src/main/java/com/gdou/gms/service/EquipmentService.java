package com.gdou.gms.service;

import com.gdou.gms.pojo.Condition;
import com.gdou.gms.pojo.EquOrder;
import com.gdou.gms.pojo.Equipment;

import java.util.List;

public interface EquipmentService
{

    public Boolean addEquipment(Equipment equipment);

    public Boolean deleteEquipment(Integer equId);

    public Equipment queryEquipment(Integer equId);

    public List<Equipment> queryAllEquipments();

    public List<Equipment> queryEquipmentsByCondition(Condition condition);

    public Boolean updateEquipment(Equipment equipment);

    public Boolean returnEquipment(Integer equOrderId);

    public Boolean addEquOrder(EquOrder equOrder);

    public Boolean repairEquipment(EquOrder equOrder);

    public Boolean deleteEquOrder(Integer equOrderId);

    public Boolean deleteEquOrderByCompetId(String competitionId);

    public EquOrder queryEquOrderByCompetId(String competitionId);

    public EquOrder queryEquOrder(Integer equOrderId);

    public List<EquOrder> queryAllEquOrders();

    public List<EquOrder> queryEquOrdersByCondition(Condition condition);

    public List<EquOrder> queryEquOrdersByUserId(String userId);

    public Boolean verifiedEquOrder(Integer equOrderId);

}
