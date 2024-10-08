package usecase;

import api.GradeDataBase;
import entity.Grade;
import entity.Team;

import java.lang.reflect.Member;

/**
 * GetAverageGradeUseCase class.
 */
public final class GetAverageGradeUseCase {
    private final GradeDataBase gradeDataBase;

    public GetAverageGradeUseCase(GradeDataBase gradeDataBase) {
        this.gradeDataBase = gradeDataBase;
    }

    /**
     * Get the average grade for a course across your team.
     * @param course The course.
     * @return The average grade.
     */
    public float getAverageGrade(String course) {
        // Call the API to get usernames of all your team members
        float sum = 0;
        int count = 0;
        // TODO Task 3b: Go to the MongoGradeDataBase class and implement getMyTeam.
        final Team team = gradeDataBase.getMyTeam();
        // Call the API to get all the grades for the course for all your team members


        for (String username: team.getMembers()) {
            Grade grade = gradeDataBase.getGrade(username, course);
            int value = grade.getGrade();
            sum += value;
            count++;
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }
}
