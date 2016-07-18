/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.entitites;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Contiene todo el modelo de datos
 * @author FernandoBadilloAyala
 */

@Getter @Setter
public class Model {
    private int id;
    private String name;

    private List<Feature> features;
    private List<Products> products;
}
