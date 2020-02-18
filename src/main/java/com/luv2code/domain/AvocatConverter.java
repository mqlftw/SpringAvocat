package com.luv2code.domain;

import java.util.ArrayList;
import java.util.List;

import com.luv2code.entities.Avocat;



public class AvocatConverter {

	public static AvocatVo toVo(Avocat bo) {
	    if( bo == null )
			return null;
		
		AvocatVo vo=new AvocatVo();
		vo.setNumAvocat(bo.getNumAvocat());
		vo.setNomAvocat(bo.getNomAvocat());
		vo.setPrenomAvocat(bo.getPrenomAvocat());
		vo.setTelAvocat(bo.getTelAvocat());
		vo.setSalaire(bo.getSalaire());
		
		return vo;
	}
	
	public static Avocat toBo(AvocatVo vo)
	{
		Avocat bo=new Avocat();
		bo.setNumAvocat(vo.getNumAvocat());
		bo.setNomAvocat(vo.getNomAvocat());
		bo.setPrenomAvocat(vo.getPrenomAvocat());
		bo.setTelAvocat(vo.getTelAvocat());
		bo.setSalaire(vo.getSalaire());
		
		return bo;
	}
	
	public static List<AvocatVo> toVoList(List<Avocat> listBo){
		
		List<AvocatVo> listVo = new ArrayList<>();
		
		for (Avocat avocat : listBo) {
			listVo.add(toVo(avocat));
		}
		
		return listVo;
	}
	public static List<AvocatVo> toListVo(List<Avocat> listBo) {
		List<AvocatVo> listVo = new ArrayList<>();
		for (Avocat avocat : listBo) {
			listVo.add(toVo(avocat));
		}
		return listVo;
	}
}
