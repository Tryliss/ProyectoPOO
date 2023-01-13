package gestorCelebraciones;

import java.util.ArrayList;

import java.util.Collections;

/** Clase evento con patron de diseño singleton */
public class Evento{
	/** Singleton */
	private static Evento instance;
	
	/** Arraylist de comensales a asignar */
	ArrayList<Comensal> asignados		=	new ArrayList<Comensal>();
	/** Mesa presidencial */
	Presidencial 		presidencial	= 	new Presidencial();
	/** Arraylist mesas niños */
	ArrayList<Ninnos> 	ninnos			= 	new ArrayList<Ninnos>();
	/** Arraylist mesas generales*/
	ArrayList<General> 	general			= 	new ArrayList<General>();
	/** Arraylist completo */
	ArrayList<Mesa> 	completo		= 	new ArrayList<Mesa>();

	/** Constructor privado por singleton */
	public Evento(ArrayList<Comensal> asignados) {
		this.asignados = asignados;
	}
	
	/** "Constructor" Singleton */
	public static Evento getInstance(ArrayList<Comensal> asignados) {
        if (instance == null) {
            instance = new Evento(asignados);
        }
        
        return instance;
    }
	
	
	
	/**Asigna y devuelve lista comensales y mesas */
	
	public ArrayList<Mesa> Asigna() {

		for(Comensal comensal: asignados) {
				determinarMesa(comensal);
			
		}
			completo.addAll(general);
			completo.add(presidencial);
			completo.addAll(ninnos);
			return completo;
	}
	
	/**Metodo que determina la mesa a la que se asigna, y llama a la asignacion */
	private void determinarMesa(Comensal comensal) {
		
		if(comensal.rol==Rol.NINNO){
			asignaNinnos(comensal);
		}
		
		if(comensal.rol==Rol.PROTAGONISTA1||comensal.rol==Rol.PROTAGONISTA2||comensal.rol==Rol.PREFERENTE){
			asignaPresidencial(comensal);
		}
		
		if(comensal.rol==Rol.INVPR2||comensal.rol==Rol.INVPR1) {
			asignaGeneral(comensal);
			asignaAcommpanantes(comensal);
		}
		
	}
	
	
	/**Asigna la mesa presencial*/
	private void asignaPresidencial(Comensal comensal){
		presidencial.annadirComensales(comensal);
	}
	
	/**Asigna niños*/
	private void asignaNinnos(Comensal comensal){
		int cont=0;
		if(ninnos.isEmpty()||Ninnos.maximo==ninnos.get(cont).comensalesMesa.size()) {
			ninnos.add(cont,new Ninnos());
			cont++;
		}else {
			ninnos.get(cont).annadirComensales(comensal);
		}
	
	}
	
	/**Asigna acompañantes*/
	private void asignaAcommpanantes(Comensal comensal) {
		for(Integer acompannante:comensal.getAcompannantes()) {
			if(acompannante!=-1) {
			Comensal comensalAcompannate=asignados.get(acompannante);
			asignaGeneral(comensalAcompannate);
			asignados.get(acompannante).setRol(Rol.ASIGNADO);
			}
		}	
	}
	
	
	/**Asignacion a mesas generales mediante pesos de mesas */
	
	private void asignaGeneral(Comensal comensal) {
		int cont=general.size();
		ArrayList<Integer> pesos = new ArrayList<Integer>();
		if(general.isEmpty()) {
			general.add(cont,new General("Placeholder"));
			general.get(cont).annadirComensales(comensal);
			return;
		}else{
			for(General mGeneral: general) {
				int puntuacion = 0;
				for(Comensal comparado:mGeneral.comensalesMesa) {
					if(comensal.vetados.contains(comparado.getIdentificador())||comparado.vetados.contains(comensal.getIdentificador())) {
						puntuacion=puntuacion-100;
					
					}
					
					if(comparado.rol==comensal.rol) {
						puntuacion++;
					}
					
					if(comensal.acompannantes.contains(comparado.getIdentificador())||comparado.acompannantes.contains(comensal.getIdentificador())) {
						puntuacion=puntuacion+100;
					}
					
					if(mGeneral.comensalesMesa.size()>12||comensal.getAcompannantes().size()+mGeneral.comensalesMesa.size()>12) {
						puntuacion=-1500;
					}
				}
				pesos.add(puntuacion);
			}
			if(Collections.max(pesos)>=0) {
				general.get(pesos.indexOf(Collections.max(pesos))).annadirComensales(comensal);

			}else{
				general.add(cont,new General("Placeholder"));
				general.get(cont).annadirComensales(comensal);
				cont++;
				
			}
		}
	}
}
