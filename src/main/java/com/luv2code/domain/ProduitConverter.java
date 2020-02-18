package com.luv2code.domain;

import java.util.ArrayList;
import java.util.List;

import com.luv2code.entities.Produit;



public class ProduitConverter {

	public static ProduitVo toVo(Produit bo) {
	    if( bo == null )
			return null;
		
	    ProduitVo vo=new ProduitVo();
		vo.setIdProduit(bo.getIdProduit());
		vo.setNomProduit(bo.getNomProduit());
		vo.setDescription(bo.getDescription());
		vo.setPrixHT(bo.getPrixHT());
		vo.setPrixTTC(bo.getPrixTTC());
		
		return vo;
	}
	
	public static Produit toBo(ProduitVo vo)
	{
		Produit bo=new Produit();
		bo.setIdProduit(vo.getIdProduit());
		bo.setNomProduit(vo.getNomProduit());
		bo.setDescription(vo.getDescription());
		bo.setPrixHT(vo.getPrixHT());
		bo.setPrixTTC(vo.getPrixTTC());
		
		return bo;
	}
	
	public static List<ProduitVo> toVoList(List<Produit> listBo){
		
		List<ProduitVo> listVo = new ArrayList<>();
		
		for (Produit produit : listBo) {
			listVo.add(toVo(produit));
		}
		
		return listVo;
	}
	public static List<ProduitVo> toListVo(List<Produit> listBo) {
		List<ProduitVo> listVo = new ArrayList<>();
		for (Produit produit : listBo) {
			listVo.add(toVo(produit));
		}
		return listVo;
	}
}
