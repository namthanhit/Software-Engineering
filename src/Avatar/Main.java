/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Avatar;

/**
 *
 * @author buingocduc
 */
import Class.BranchActivity;
import Database.ListBranchActivity;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Thay đổi giá trị orgId theo giá trị bạn muốn kiểm tra
        String orgId = "ORG01";

        // Lấy danh sách các hoạt động dựa trên orgId
        List<BranchActivity> activities = ListBranchActivity.getBranchActivitiesByOrgId(orgId);

        // In ra danh sách các hoạt động đã tìm thấy
        if (!activities.isEmpty()) {
            for (BranchActivity activity : activities) {
                System.out.println("Activity ID: " + activity.getId());
                System.out.println("Activity Name: " + activity.getActivityName());
                System.out.println("Start Date: " + activity.getStartDate());
                System.out.println("End Date: " + activity.getEndDate());
                System.out.println("Status: " + activity.getStatus());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("-----------------------------------------");
            }
        } else {
            System.out.println("No activities found for orgId: " + orgId);
        }
    }
}