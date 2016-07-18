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
 *
 * @author FernandoBadilloAyala
 */

@Getter @Setter
public class Products {
    private int id;
    private String name;
    private String description;
    private String image;
    private List<FeatureValue> feartureValue;
}