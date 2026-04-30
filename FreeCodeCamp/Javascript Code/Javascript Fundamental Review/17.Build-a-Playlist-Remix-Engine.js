const playlists = [
  [
    {
      trackId: "trk101",
      artist: "Velvet Comet",
      title: "Crimson Afterglow",
      votes: 5,
      bpm: 122
    },
    {
      trackId: "trk102",
      artist: "Neon Harbor",
      title: "Static Horizon",
      votes: 2,
      bpm: 108
    },
    {
      trackId: "trk103",
      artist: "Lunar Arcade",
      title: "Midnight Frequency",
      votes: 4,
      bpm: 128
    }
  ],
  [
    {
      trackId: "trk201",
      artist: "Solar Echo",
      title: "Glass Skyline",
      votes: 3,
      bpm: 115
    },
    {
      trackId: "trk202",
      artist: "Velvet Comet",
      title: "Satellite Hearts",
      votes: 6,
      bpm: 124
    }
  ]
];

function flattenPlaylists(playlists) {
  if (!Array.isArray(playlists)) return [];
  const flat = [];
  playlists.forEach((playlist, pIndex) => {
    playlist.forEach((track, tIndex) => {
      flat.push({
        ...track,
        source: [pIndex, tIndex]
      });
    });
  });
  return flat;
}

function scoreTracks(tracks) {
  return tracks.map(track => ({
    ...track,
    score: track.votes * 10 - Math.abs(track.bpm - 120)
  }));
}

function dedupeTracks(tracks) {
  const seen = new Set();
  return tracks.filter(track => {
    if (seen.has(track.trackId)) return false;
    seen.add(track.trackId);
    return true;
  });
}

function enforceArtistQuota(tracks, maxPerArtist) {
  const artistCounts = {};
  return tracks.filter(track => {
    artistCounts[track.artist] = (artistCounts[track.artist] || 0) + 1;
    return artistCounts[track.artist] <= maxPerArtist;
  });
}

function buildSchedule(tracks) {
  return tracks.map((track, index) => ({
    slot: index + 1,
    trackId: track.trackId
  }));
}

function remixPlaylist(playlists, maxPerArtist) {
  const flat = flattenPlaylists(playlists);
  const scored = scoreTracks(flat);
  const deduped = dedupeTracks(scored);
  const limited = enforceArtistQuota(deduped, maxPerArtist);
  return buildSchedule(limited);
}