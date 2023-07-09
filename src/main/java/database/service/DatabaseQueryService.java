package database.service;

import database.Database;
import dto.LongestProject;
import dto.MaxProjectsClient;
import dto.MaxSalaryWorker;
import dto.PriceProject;
import dto.YoungestEldestWorker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String FIND_MAX_SALARY_WORKER_FILE = "sql/find_max_salary_worker.sql";
    private static final String FIND_MAX_PROJECTS_CLIENT_FILE = "sql/find_max_projects_client.sql";
    private static final String FIND_LONGEST_PROJECT_FILE = "sql/find_longest_project.sql";
    private static final String FIND_YOUNGEST_ELDEST_WORKERS_FILE = "sql/find_youngest_eldest_workers.sql";
    private static final String PRINT_PROJECT_PRICES_FILE = "sql/print_project_prices.sql";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_SALARY = "salary";
    private static final String COLUMN_LABEL_PROJECT_COUNT = "project_count";
    private static final String COLUMN_LABEL_MONTH_COUNT = "month_count";
    private static final String COLUMN_LABEL_TYPE = "type";
    private static final String COLUMN_LABEL_BIRTHDAY = "birthday";
    private static final String COLUMN_LABEL_PRICE = "price";
    private final Connection connection = Database.getInstance().getConnection();

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalaryWorkerList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(FIND_MAX_SALARY_WORKER_FILE));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                maxSalaryWorker.setName(resultSet.getString(COLUMN_LABEL_NAME));
                maxSalaryWorker.setSalary(resultSet.getInt(COLUMN_LABEL_SALARY));
                maxSalaryWorkerList.add(maxSalaryWorker);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return maxSalaryWorkerList;
    }

    public List<MaxProjectsClient> findMaxProjectsClient() {
        List<MaxProjectsClient> maxProjectsClientList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(FIND_MAX_PROJECTS_CLIENT_FILE));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                MaxProjectsClient maxProjectsClient = new MaxProjectsClient();
                maxProjectsClient.setName(resultSet.getString(COLUMN_LABEL_NAME));
                maxProjectsClient.setProjectCount(resultSet.getInt(COLUMN_LABEL_PROJECT_COUNT));
                maxProjectsClientList.add(maxProjectsClient);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return maxProjectsClientList;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjectList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(FIND_LONGEST_PROJECT_FILE));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                LongestProject longestProject = new LongestProject();
                longestProject.setName(resultSet.getString(COLUMN_LABEL_NAME));
                longestProject.setMonthCount(resultSet.getInt(COLUMN_LABEL_MONTH_COUNT));
                longestProjectList.add(longestProject);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return longestProjectList;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        List<YoungestEldestWorker> youngestEldestWorkerList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(FIND_YOUNGEST_ELDEST_WORKERS_FILE));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
                youngestEldestWorker.setType(resultSet.getString(COLUMN_LABEL_TYPE));
                youngestEldestWorker.setName(resultSet.getString(COLUMN_LABEL_NAME));
                youngestEldestWorker.setBirthday(resultSet.getString(COLUMN_LABEL_BIRTHDAY));
                youngestEldestWorkerList.add(youngestEldestWorker);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return youngestEldestWorkerList;
    }

    public List<PriceProject> findProjectPrices() {
        List<PriceProject> projectPriceList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(PRINT_PROJECT_PRICES_FILE));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                PriceProject projectPrice = new PriceProject();
                projectPrice.setName(resultSet.getString(COLUMN_LABEL_NAME));
                projectPrice.setPrice(resultSet.getInt(COLUMN_LABEL_PRICE));
                projectPriceList.add(projectPrice);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return projectPriceList;
    }
}
