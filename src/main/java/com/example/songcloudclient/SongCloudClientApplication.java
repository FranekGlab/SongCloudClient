package com.example.songcloudclient;

import com.example.songcloudclient.proxy.SongCloudClient;
import com.example.songcloudclient.request.AddSongRequest;
import com.example.songcloudclient.request.UpdateSongRequest;
import com.example.songcloudclient.response.DeleteSongResponse;
import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Log4j2
@EnableFeignClients
public class SongCloudClientApplication {

    private final SongCloudClient songCloudClient;

    public SongCloudClientApplication(SongCloudClient songCloudClient) {
        this.songCloudClient = songCloudClient;
    }


    public static void main(String[] args) {
        SpringApplication.run(SongCloudClientApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequests() {
        try {
            log.info(songCloudClient.addSong(new AddSongRequest("Kalinka", "Red Army Choir")));
            log.info(songCloudClient.getSongById(1, "getById"));
            log.info(songCloudClient.getAllSongs());
            DeleteSongResponse response = songCloudClient.deleteSongById(3);
            log.info(response);
            log.info(songCloudClient.updateSongByPut(4, new UpdateSongRequest("Monster", "Skillet")));
            log.info(songCloudClient.updateSongByPatch(2, new UpdateSongRequest("Diamonds", null)));

        } catch (FeignException.FeignClientException feignClientException) {
            log.error("Client exception: " + feignClientException.getMessage() + " " + feignClientException.status());
        } catch (FeignException.FeignServerException feignServerException) {
            log.error("Server exception: " + feignServerException.getMessage() + " " + feignServerException.status());
        } catch (RetryableException retryableException) {
            log.error("Retryable exception: " + retryableException.getMessage() + retryableException.status());
        } catch (FeignException feignException) {
            log.error("Feign exception: " + feignException.getMessage() + " " + feignException.status());
        }
    }

}
