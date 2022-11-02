package gestorBoda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Asignador{
	List<Comensal> asignados;
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
					break;
				case  4:
					asignaGeneral(comensal);
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
	private void asignaGeneral(Comensal comensal) {
		int cont=general.size();
		//Hacer con mapas¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡
		ArrayList<Integer> pesos = new ArrayList<Integer>();
		if(general.isEmpty()) {
			general.add(cont,new General("Placeholder"));
			general.get(cont).annadirComensales(comensal);
			return;
			
		}else{
			for(General mGeneral: general) {
				int puntuacion = 0;
				if(mGeneral.comensalesMesa.size()>12) {
					puntuacion=-1500;
				}else {
				for(Comensal comparado:mGeneral.comensalesMesa) {
					if(comparado.rol==comensal.rol) {
						puntuacion++;
					}
					if(comensal.acompannantes.contains(comparado)||comparado.acompannantes.contains(comensal)) {
						puntuacion=puntuacion+100;
					}
					if(comensal.vetados.contains(comparado)||comparado.vetados.contains(comensal)) {
						puntuacion=puntuacion-100;
					}
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
