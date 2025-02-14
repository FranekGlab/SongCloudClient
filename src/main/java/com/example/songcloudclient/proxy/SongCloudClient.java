package com.example.songcloudclient.proxy;

import com.example.songcloudclient.config.FeignConfiguration;
import com.example.songcloudclient.request.AddSongRequest;
import com.example.songcloudclient.request.UpdateSongRequest;
import com.example.songcloudclient.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "songcloud-server-url", configuration = FeignConfiguration.class)
public interface SongCloudClient {

    @PostMapping("/songs")
    AddSongResponse addSong(@RequestBody AddSongRequest song);

    @GetMapping("/songs/{id}")
    SingleSongResponse getSongById(@PathVariable Integer id, @RequestHeader String requestId);

    @GetMapping("/songs")
    AllSongsResponse getAllSongs();

    @DeleteMapping("/songs/{id}")
    DeleteSongResponse deleteSongById(@PathVariable Integer id);

    @PutMapping("/songs/{id}")
    UpdateSongByPutResponse updateSongByPut(@PathVariable Integer id, @RequestBody UpdateSongRequest song);

    @PatchMapping("/songs/{id}")
    UpdateSongByPatchResponse updateSongByPatch(@PathVariable Integer id, @RequestBody UpdateSongRequest song);


}
