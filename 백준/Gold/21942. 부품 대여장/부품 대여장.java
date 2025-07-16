import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, LocalDateTime> rentalRecords = new HashMap<>();
        Map<String, Long> totalPenalties = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());

        String borrowPeriodStr = st.nextToken();
        String[] periodParts = borrowPeriodStr.split("/");
        int days = Integer.parseInt(periodParts[0]);
        String[] timeParts = periodParts[1].split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        Duration borrowDuration = Duration.ofDays(days).plusHours(hours).plusMinutes(minutes);

        long penaltyPerMinute = Long.parseLong(st.nextToken());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String dateTimeStr = st.nextToken() + " " + st.nextToken(); 
            String itemName = st.nextToken(); 
            String nickname = st.nextToken(); 

            LocalDateTime currentEventTime = LocalDateTime.parse(dateTimeStr, formatter);
            String mapKey = itemName + " " + nickname;

            if (rentalRecords.containsKey(mapKey)) {
                LocalDateTime rentalStartTime = rentalRecords.get(mapKey);
                rentalRecords.remove(mapKey); 

                LocalDateTime deadline = rentalStartTime.plus(borrowDuration);

                if (currentEventTime.isAfter(deadline)) {

                    long overdueMinutes = Duration.between(deadline, currentEventTime).toMinutes();
                    long currentPenalty = overdueMinutes * penaltyPerMinute;

                    totalPenalties.put(nickname, totalPenalties.getOrDefault(nickname, 0L) + currentPenalty);
                }
            } else {
                rentalRecords.put(mapKey, currentEventTime);
            }
        }

        if (totalPenalties.isEmpty()) {
            bw.write("-1\n");
        } else {
            List<Map.Entry<String, Long>> sortedPenalties = new ArrayList<>(totalPenalties.entrySet());
            sortedPenalties.sort(Map.Entry.comparingByKey());

            for (Map.Entry<String, Long> entry : sortedPenalties) {
                bw.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
