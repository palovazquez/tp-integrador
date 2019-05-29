package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {

	protected Arbol<E> izquierdo;
	protected Arbol<E> derecho;
	
	public ArbolBinarioBusqueda(){
		this.valor=null;
		this.izquierdo=new ArbolVacio<E>();
		this.derecho=new ArbolVacio<E>();
	}
	
	public ArbolBinarioBusqueda(E e){
		this.valor=e;
		this.izquierdo=new ArbolVacio<E>();
		this.derecho=new ArbolVacio<E>();
	}
	
	public ArbolBinarioBusqueda(E e,Arbol<E> i,Arbol<E> d){
		this.valor=e;
		this.izquierdo=i;
		this.derecho=d;
	}
	
	@Override
	public List<E> preOrden() {
		List<E> lista = new ArrayList<E>();
		lista.add(this.valor);
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		return lista;
	}
	@Override
	public List<E> inOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.preOrden());
		lista.add(this.valor);
		lista.addAll(this.derecho.preOrden());
		return lista;
	}
	@Override
	public List<E> posOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		lista.add(this.valor);
		return lista;

	}
	@Override
	public boolean esVacio() {
		return false;
	}
        
	@Override
	public E valor() {
		return this.valor;
	}
	
	@Override
	public Arbol<E> izquierdo() {
		return this.izquierdo;
	}
	
	@Override
	public Arbol<E> derecho() {
		return this.derecho;
	}


	@Override
	public void agregar(E a) {
		if(this.valor.compareTo(a)<1) {
			if (this.derecho.esVacio()) this.derecho = new ArbolBinarioBusqueda<E>(a);
			else this.derecho.agregar(a);
		}else {
			if (this.izquierdo.esVacio()) this.izquierdo= new ArbolBinarioBusqueda<E>(a);
			else this.izquierdo.agregar(a);
		}
	}
	
	@Override
	public boolean equals(Arbol<E> unArbol) {
		return this.valor.equals(unArbol.valor()) && this.izquierdo.equals(unArbol.izquierdo()) && this.derecho.equals(unArbol.derecho());
	}

	@Override
	public boolean contiene(E unValor) {
		return this.valor.equals(unValor) ||
				this.izquierdo.contiene(unValor) ||
				this.derecho.contiene(unValor);
		// TODO
	}

	@Override
	public int profundidad() {
		return 1 + Math.max(izquierdo.profundidad(), derecho.profundidad());
		// TODO
		//1.b
	}

	@Override
	public int cuentaNodosDeNivel(int nivel) {
		if (this.profundidad() == nivel)
			return 1;
		else
			return this.izquierdo.cuentaNodosDeNivel(nivel) + this.derecho.cuentaNodosDeNivel(nivel);
	
		// TODO 
		
	}

	@Override
	public boolean esCompleto() {
	int m = izquierdo.profundidad()-derecho.profundidad();
		if(m == 1 && izquierdo.esCompleto() && derecho.esLleno()) {
			return true;
		}else if (m == 0 && izquierdo.esLleno() && derecho.esCompleto()) {
			return true;
		
			
		}else
			return false;
		
		
		// TODO 1.d
		// return false;
	}

	@Override
	public boolean esLleno() {
		for(int i=0; i<=this.profundidad(); i++) {
			if(this.cuentaNodosDeNivel(i)!= Math.pow(2, this.profundidad()))
				return false;
		}
		return true;
		// TODO 
	}

}
