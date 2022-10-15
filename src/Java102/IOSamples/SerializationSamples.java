package Java102.IOSamples;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class SerializationSamples {
    public static void main(String[] args) {
        /*
        File path = new File("src/Java102/IOSamples/files");
        path.mkdir();

        File path2 = new File("src/Java102/IOSamples/files/test/deneme");
        path2.mkdirs();
         */

        File file = new File("src/Java102/IOSamples/sample.txt");
        try {
            if (file.createNewFile()) {
                System.out.println(file.getName() + " dosyası oluşturuldu.");
            } else {
                System.out.println(file.getName() + " dosyası zaten mevcut.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(file.delete());

        File pathFile = new File("src/Java102/IOSamples");
        String[] list = pathFile.list();

        for (String value : list) {
            System.out.println(value);
        }

        String path = "src/Java102/IOSamples/"; // PATH
        try {
            FileInputStream stream = new FileInputStream(path + "sample.txt");
            // System.out.println(stream.read()); // İlk karakterin byte değerini döndürme.
            System.out.println("Byte sayısı: " + stream.available()); // Her read()'de değeri 1 azalır.
            // stream.skip(6); // İlk n karakteri atlar.
            int i = stream.read();
            while (i != -1) {
                System.out.print((char) i);
                i = stream.read();
            }
            stream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String text = "\n\nOutputStream öğreniyoruz.\nPatika.dev\n\n";
        try {
            // append; dosyanın içindeki verinin sonuna ekleme yapar.
            // append kullanılmazsa, dosyayı sıfırdan oluşturur ve üzerine yazar.
            FileOutputStream output = new FileOutputStream(path + "sample.txt", true);
            byte[] textByte = text.getBytes();
            output.write(textByte);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] dizi = {1, 2, 3, 54, 66, 20, 43, 34};
        // Dizi başlangıç değeri ve kaç karakteri alacağı da belirlenebilir.
        ByteArrayInputStream input = new ByteArrayInputStream(dizi, 2, 3);
        System.out.println(input.read());
        System.out.println(input.read());
        input.skip(2); // İlk 2 elemanı atlar.
        System.out.println("Byte sayısı: " + input.available());

        int ii = input.read();
        while (ii != -1) {
            System.out.println(ii);
            ii = input.read();
        }
        try {
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Örnek:
        byte[] array = {1, 2, 3, 4};
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(array);

            System.out.println("Available bytes at the beginning: " + inputStream.available());

            System.out.println("The bytes read from the input stream: ");
            for (int j = 0; j < array.length; j++) {
                int data = inputStream.read();
                System.out.print(data + ", ");
            }
            System.out.println("Available bytes at the beginning: " + inputStream.available());
            inputStream.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        // ByteArrayOutputStream
        String value = "Java 102 Dersleri...";
        byte[] valueBytes = value.getBytes();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(valueBytes);
            System.out.println("String hali: " + Arrays.toString(valueBytes));
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Car c1 = new Car("Ford", "Focus Estate 2014");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "car.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(c1);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(path + "car.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Car newCar = (Car) objectInputStream.readObject();
            System.out.println(newCar.getBrand());
            System.out.println(newCar.getModel());
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(path + "patika.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            int i = bufferedInputStream.read();
            while (i != -1) {
                System.out.print((char) i);
                i = bufferedInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String data = "\n*** Java 102 Patikasi ***";
        try {
            // append:true sonuna ekleme yapar.
            FileOutputStream fileOutputStream = new FileOutputStream(path + "patika.txt", true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] byteArray = data.getBytes();
            bufferedOutputStream.write(byteArray);
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            PrintStream printStream = new PrintStream(path + "output.txt");
            printStream.print(data);
            printStream.close();
        }
        catch(Exception e) {
            e.getStackTrace();
        }

        // UTF8 Türkçe karakterleri düzgün bir şekilde okuyabilme.
        try {
            FileInputStream fileInputStream = new FileInputStream(
                    path + "inputStreamReaderSample.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            System.out.println("\nEncoding: " + inputStreamReader.getEncoding());

            int i = inputStreamReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = inputStreamReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // getBytes metodu kullanmadan direk write yapabilme.
        String dataWriterTest = "ĞĞÜÜ-ŞŞİİ";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "out.txt", true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            System.out.println("\nEncoding: " + outputStreamWriter.getEncoding());
            fileOutputStream.write(dataWriterTest.getBytes());
            outputStreamWriter.write(dataWriterTest + "\n");
            outputStreamWriter.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileReader = new FileReader(path + "out.txt", Charset.forName("Big5"));
            fileReader.skip(2); // n karakteri okumadan atlar.
            int i = fileReader.read();
            while (i != -1) {
                System.out.print((char) i);
                i = fileReader.read();
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String data2 = "JAVA ÖĞRENİYORUM\n";

        try {
            FileWriter fileWriter = new FileWriter(path + "out.txt", true);
            fileWriter.write(data2);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileReader = new FileReader(path + "patika.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Satır satır okuma sağlar.
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fileWriter = new FileWriter(path + "out.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Java 102 Dersleri");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String pwData = "Java 102 Öğreniyorum";
        try {
            PrintWriter printWriter = new PrintWriter(path + "output.txt");
            printWriter.print(pwData); // Her şeyi String'e çevirir
            printWriter.close();

            // PrintWriter sınıfı herhangi bir girdi / çıktı istisnası (Exception) atmaz.
            // Bunun yerine, içindeki herhangi bir hatayı bulmak için
            // checkError() metodu kullanmamız gerekir.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Car implements Serializable {
    private String brand, model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}