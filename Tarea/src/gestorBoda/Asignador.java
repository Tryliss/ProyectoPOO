package gestorBoda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Asignador{
	ArrayList<Comensal> asignados=new ArrayList<Comensal>();
	//Solo puede haber una mesa presidencial
	Presidencial presidencial= new Presidencial();
	ArrayList<Ninnos> ninnos= new ArrayList<Ninnos>();
	ArrayList<General> general= new ArrayList<General>();
	ArrayList<Mesa> completo= new ArrayList<Mesa>();

	public Asignador(ArrayList<Comensal> asignados) {
		this.asignados = asignados;
	}
	
	public ArrayList<Mesa> Inicia() {
		//Introduce a los asistentes en listas segun su rol
			for(Comensal comensal: asignados) {
				switch(comensal.rol) {
				case -1:
					break;
				case  5:
					asignaNinnos(comensal);
					break;
				case  0:
					asignaPresidencial(comensal);
					break;
				case  1:
					asignaPresidencial(comensal);
					break;
				case  2:
					asignaPresidencial(comensal);
					break;
				case  3:
					asignaGeneral(comensal);
					asignaAcommpanantes(comensal);
					break;
				case  4:
					asignaGeneral(comensal);
					asignaAcommpanantes(comensal);
					break;
				default:
					break;
					
			}
			
		}
			completo.addAll(general);
			completo.add(presidencial);
			completo.addAll(ninnos);
			return completo;
	}

	private void asignaPresidencial(Comensal comensal){
		presidencial.annadirComensales(comensal);
	}
	
	private void asignaNinnos(Comensal comensal){
		int cont=0;
		if(ninnos.isEmpty()||Mesa.maximo==ninnos.get(cont).comensalesMesa.size()) {
			ninnos.add(cont,new Ninnos());
			cont++;
		}else {
			ninnos.get(cont).annadirComensales(comensal);
		}
	
	}
	private void asignaAcommpanantes(Comensal comensal) {
		for(Integer i:comensal.getAcompannantes()) {
			if(i!=-1) {
			Comensal aux=asignados.get(i);
			asignaGeneral(aux);
			asignados.get(i).setRol(-2);
			}
		}
		
	}
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
				pesos.add( puntuacion);
			}
			if(Collections.max(pesos)>=0) {
				general.get(pesos.indexOf(Collections.max(pesos))).annadirComensales(comensal);

			}else {
				
				general.add(cont,new General("Placeholder"));
				general.get(cont).annadirComensales(comensal);
				cont++;
			}
			
		}

	}
}
