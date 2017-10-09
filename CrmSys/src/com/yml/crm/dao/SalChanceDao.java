package com.yml.crm.dao;

import java.util.List;
import com.yml.crm.domain.SalChance;
public interface SalChanceDao {
	public List<SalChance> getSalChancesByWhere(String where);
	public void save(SalChance sal);//保存
	public void update(SalChance sal);//更新
	public SalChance getSalChanceById(long id);//根据id查找
	public void delSalChanceById(long id);//根据id删除
	public void updatechcStatus(SalChance sal);
}
