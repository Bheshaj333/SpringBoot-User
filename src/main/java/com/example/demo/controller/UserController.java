package com.example.demo.controller;

import com.example.demo.entity.GCPModControl;
import com.example.demo.entity.KubernetesModControl;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/user")
@Slf4j
public class UserController  {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/getRandomUser")
    public Object getRandomUser() throws IOException, InterruptedException {

        String csvFile = "D:\\accounts.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header line (accountID,email,name)
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] columns = line.split(cvsSplitBy);

                // Extract the values of different columns
                String accountID = columns[0];
                String email = columns[1];
                String name = columns[2];

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userService.getRandomUser();
    }

    @Async
    CompletableFuture<Void> demoTask() throws InterruptedException {
        for(int i = 0; i<10; i++){
            Thread.sleep(1000);
            System.out.println(i);
        }
        return CompletableFuture.completedFuture(null);
    }









    @GetMapping(path = "/getRandomUserd")
    public void getUserById() {

    }


    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/setUser")
    public boolean setUser(@RequestBody User user) {
        return userService.setUser(user);
    }

    @GetMapping(path = "/updateUsingSaveMethod/{id}")
    public boolean updateUsingSaveMethod(@PathVariable int id) {
        return userService.updateUsingSaveMethod(id);
    }

    public String modifyTableNameToClass(String tableName) {
        String className = "";
        String classNameTest[] = tableName.split("_");
        for(String s : classNameTest){
            String firstChar =  (s.charAt(0)+"").toUpperCase();
            String rest = s.substring(1);
            String finalName = firstChar + rest;
            className += finalName;
        }
        return className;
    }

    public String modifyColumnName(String columnName) {
        String columnNameTest[] = columnName.split("_");
        String colName = columnNameTest[0];
        if(columnNameTest.length > 1){
            for(int i = 1; i<columnNameTest.length; i++){
                String firstChar =  (columnNameTest[i].charAt(0)+"").toUpperCase();
                String rest = columnNameTest[i].substring(1);
                String finalName = firstChar + rest;
                colName += finalName;
            }
        }
        return colName;
    }

    public void extras() throws IOException {

        /*
            To get the table names and column and create the models automatically
        */

        /*
        TreeMap<String, Map<String, String>> tablesMap = new TreeMap<>();
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("org", "turbot");
        params.add("name", "kubernetes");
        params.add("table", "kubernetes_cluster_role");
        ResponseEntity<String> response = restTemplate.exchange("https://hub.steampipe.io/_next/data/pIqkWK0aLvxoWTS2sGD-O/plugins/turbot/kubernetes/tables/kubernetes_cluster_role.json", HttpMethod.GET, null, String.class, params);
        String responseBody = response.getBody();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject pageProps = jsonObject.getJSONObject("pageProps");
        JSONObject plugin = pageProps.getJSONObject("plugin");
        JSONArray tables = plugin.getJSONArray("tables");
        for(int i = 0; i<tables.length(); i++){
            TreeMap<String, String> tableBody = new TreeMap<>();
            JSONObject tableObject = tables.getJSONObject(i);
            String tableName = tableObject.getString("name");
            if(tableName.equals("kubernetes_{custom_resource_singular_name}")){
                continue;
            }
            ResponseEntity<String> tableResponse = restTemplate.exchange("https://hub.steampipe.io/_next/data/pIqkWK0aLvxoWTS2sGD-O/plugins/turbot/kubernetes/tables/"+tableName+".json", HttpMethod.GET, null, String.class);
            String tableResponseBody = tableResponse.getBody();
            JSONObject tableResponseObject = new JSONObject(tableResponseBody);
            JSONObject tablePageProps = tableResponseObject.getJSONObject("pageProps");
            JSONObject tableObject2 = tablePageProps.getJSONObject("table");
            JSONArray columns = tableObject2.getJSONArray("columns");
            System.out.println("Table Name : " + tableName + " Size : " + columns.length());
            for(int j = 0; j<columns.length(); j++){
                JSONObject columnObject = columns.getJSONObject(j);
                String columnName = columnObject.getString("name");
                String columnType = columnObject.getString("type");
                if(!columnName.equals("_ctx")){
                    tableBody.put(columnName, columnType);
                }
            }
            tablesMap.put(tableName, tableBody);
        }

        for(Map.Entry<String, Map<String, String>> entry : tablesMap.entrySet()) {
            String tableName = entry.getKey();
            String className = modifyTableNameToClass(tableName);
//            File file = new File("D:\\Work\\Projects\\SpringBoot\\demo\\demo\\src\\main\\java\\com\\example\\demo\\entity\\"+className+".java");
            File file = new File("D:\\Clouddefense\\Repo\\clouddefense-server\\src\\main\\java\\ai\\clouddefense\\cloud\\kubernetes\\model\\"+className+".java");
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println("package com.example.demo.entity;\n\n");
            printWriter.println("package ai.clouddefense.cloud.kubernetes.model;\n\n");
            printWriter.println("import javax.persistence.Column;\n" +
                    "import org.hibernate.annotations.Type;\n"+
                    "import javax.persistence.Entity;\n" +
                    "import javax.persistence.Id;\n" +
                    "import javax.persistence.Table;\n"+
                    "import lombok.Data;\n" +
                    "import java.time.ZonedDateTime;\n" +
                    "import java.util.UUID;\n\n" +
                    "@Entity\n" +
                    "@Table(schema = \"kubernetes\", name = \"" + tableName + "\"" +")\n" +
                    "@Data\n" +
                    "public class " + className + " {\n");
            printWriter.println("@Id\n" +
                    "private UUID cdId = UUID.randomUUID();\n" +
                    "\n" +
                    "@Column private String accountId;\n" +
                    "\n" +
                    "@Column private UUID cdOrgId;\n" +
                    "\n" +
                    "@Column private long cdSnapshotVersion;\n");
            for(Map.Entry<String, String> column : entry.getValue().entrySet()){
                switch (column.getValue()){
                    case "jsonb":
                        printWriter.println("@Type(type = \"jsonb\")\n" +
                                "@Column(columnDefinition = \"jsonb\")\n" +
                                "private Object " + modifyColumnName(column.getKey()) + ";\n");
                        break;
                    case "bigint":
                        printWriter.println("@Column private long " + modifyColumnName(column.getKey())+";\n");
                        break;
                    case "text":
                        printWriter.println("@Column(columnDefinition = \"text\")\n" +
                                "private String " + modifyColumnName(column.getKey()) + ";\n");
                        break;
                    case "timestamp with time zone" :
                        printWriter.println("@Column private ZonedDateTime "+ modifyColumnName(column.getKey()) +";\n");
                        break;
                    case "boolean" :
                        printWriter.println("@Column private boolean "+ modifyColumnName(column.getKey()) +";\n");
                        break;
                    default:
                        printWriter.println("@Column private "+ modifyColumnName(column.getKey()) +";\n");
                        break;
                }
            }
            printWriter.println("}");
            fileWriter.close();
            printWriter.close();
        }*/






        /*
            To parse 1 json and store it in db and also create file for each table (Single json file)
        */

        /*Path path2 = Path.of("D:\\Clouddefense\\control.json");
        String str2 = Files.readString(path2);
        JSONArray array = new JSONArray(str2);
        int count = 0;
        try {
            System.out.println("Size : " +array.length());
            for (int i = 0; i<array.length(); i++){
                JSONObject jsonObject2 = (JSONObject) array.get(i);
//                KubernetesModControl kubernetesModControl = new KubernetesModControl();
//                kubernetesModControl.setArgs(jsonObject.get("args").toString());
//                kubernetesModControl.setAutoGenerated(jsonObject.getBoolean("auto_generated"));
//                kubernetesModControl.setDescription(jsonObject.get("description").toString());
//                kubernetesModControl.setDocumentation(jsonObject.get("documentation").toString());
//                kubernetesModControl.setEndLineNumber(jsonObject.getLong("end_line_number"));
//                kubernetesModControl.setFileName(jsonObject.get("file_name").toString());
//                kubernetesModControl.setAnonymous(jsonObject.getBoolean("is_anonymous"));
//                kubernetesModControl.setModName(jsonObject.get("mod_name").toString());
//                kubernetesModControl.setParams(jsonObject.get("params").toString());
//                kubernetesModControl.setPath(jsonObject.get("path").toString());
//                kubernetesModControl.setQualifiedName(jsonObject.get("qualified_name").toString());
//                kubernetesModControl.setQuery(jsonObject.get("query").toString());
//                kubernetesModControl.setResourceName(jsonObject.get("resource_name").toString());
//                kubernetesModControl.setSeverity(jsonObject.get("severity").toString());
//                kubernetesModControl.setSourceDefinition(jsonObject.get("source_definition").toString());
//                kubernetesModControl.setSql(jsonObject.get("sql").toString());
//                kubernetesModControl.setStartLineNumber(jsonObject.getLong("start_line_number"));
//                kubernetesModControl.setTags(jsonObject.get("tags").toString());
//                kubernetesModControl.setTitle(jsonObject.get("title").toString());
//                kubernetesModControlRepository.save(kubernetesModControl);
                File file = new File("D:\\Clouddefense\\Repo\\clouddefense-server\\src\\main\\resources\\data\\kubernetes\\compilance\\modControl\\"+jsonObject2.get("resource_name").toString()+".json");
//                File file = new File("D:\\Work\\Projects\\SpringBoot\\demo\\demo\\src\\main\\resources\\data\\kubernetes\\compliance\\modControl\\"+jsonObject2.get("resource_name").toString()+".json");
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(jsonObject2.toString());
                fileWriter.close();
                count++;
            }
            System.out.println("Count : " +count);
        } catch (Exception e){
            System.out.println("Stack trace : "+e.getStackTrace());
            System.out.println("Message : "+e.getMessage());
            System.out.println("Cause : "+e.getCause());
        }*/





        /*
            To parse every json file and store it in db (Multiple json files convert to json)
        */

        /*try{
            File dir = new File("D:\\Work\\Projects\\SpringBoot\\demo\\demo\\src\\main\\resources\\data\\kubernetes\\compliance\\modControl");
            if (!dir.exists()) {
                log.error(dir + " directory does not exists");
            }
            File[] files = dir.listFiles();
            List<KubernetesModControl> modControlList = new ArrayList<>();
            for(File file : files) {
                FileSystemResource resource = new FileSystemResource(file);
                String fileContent = readFromFile(resource);
                JSONObject jsonObject = new JSONObject(fileContent);
                KubernetesModControl kubernetesModControl = new KubernetesModControl();
                kubernetesModControl.setArgs(jsonObject.get("args").toString());
                kubernetesModControl.setAutoGenerated(jsonObject.getBoolean("auto_generated"));
                kubernetesModControl.setDescription(jsonObject.get("description").toString());
                kubernetesModControl.setDocumentation(jsonObject.get("documentation").toString());
                kubernetesModControl.setEndLineNumber(jsonObject.getLong("end_line_number"));
                kubernetesModControl.setFileName(jsonObject.get("file_name").toString());
                kubernetesModControl.setAnonymous(jsonObject.getBoolean("is_anonymous"));
                kubernetesModControl.setModName(jsonObject.get("mod_name").toString());
                kubernetesModControl.setParams(jsonObject.get("params").toString());
                kubernetesModControl.setPath(jsonObject.get("path").toString());
                kubernetesModControl.setQualifiedName(jsonObject.get("qualified_name").toString());
                kubernetesModControl.setQuery(jsonObject.get("query").toString());
                kubernetesModControl.setResourceName(jsonObject.get("resource_name").toString());
                kubernetesModControl.setSeverity(jsonObject.get("severity").toString());
                kubernetesModControl.setSourceDefinition(jsonObject.get("source_definition").toString());
                kubernetesModControl.setSql(jsonObject.get("sql").toString());
                kubernetesModControl.setStartLineNumber(jsonObject.getLong("start_line_number"));
                kubernetesModControl.setTags(jsonObject.get("tags").toString());
                kubernetesModControl.setTitle(jsonObject.get("title").toString());
                modControlList.add(kubernetesModControl);
            }
            System.out.println(modControlList.size());
            System.out.println(modControlList);
        }catch (Exception e){
            log.error("Erorrrrr", e);
        }*/

    }

    private String readFromFile(FileSystemResource resource) throws IOException {
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }
}