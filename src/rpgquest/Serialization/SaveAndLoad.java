/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgquest.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import rpgquest.Model.Map;

/**
 *
 * @author conno
 */
public class SaveAndLoad {
    public static void SaveMap(Map map) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("default.map");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Serialization failed. " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Some other error. " + ex.getMessage());
        }
    }

    /**
     * public static Map LoadMap() { try { FileInputStream fileInputStream = new
     * FileInputStream("default.map"); ObjectInputStream objectInputStream = new
     * ObjectInputStream(fileInputStream); Map map = (Map)
     * objectInputStream.readObject();
     *
     * } catch (FileNotFoundException ex) { System.out.println("Serialization
     * failed. " + ex.getMessage()); } catch (IOException ex) {
     * System.out.println("Input Output error. " + ex.getMessage()); } catch
     * (ClassNotFoundException ex) { System.out.println("Couldn't find class " +
     * ex.getMessage()); } catch (Exception ex) { System.out.println("Some other
     * error. " + ex.getMessage()); }
      *
     */ 
        
    }
