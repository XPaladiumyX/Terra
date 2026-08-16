# World packs — updated for 26.1.2

Custom config packs maintained by SkyXNetwork, updated to work with the Minecraft block set of
Paper 26.1.2. Each pack below was fixed and then verified on a local Paper 26.1.2 test server
(loads without errors).

## How to install

1. Stop the server.
2. Copy the zip into `plugins/Terra/packs/`.
3. Remove any other pack with the **same pack ID** (e.g. don't run the official `ReimagEND.zip`
   next to `ReimagEND-v2.3.7.zip` — both register as `REIMAGEND`).
4. Start the server and create/point a world at the generator `Terra:<pack-id>`.

## Packs

### Origen — 2.2.0 (fixed)
- **File:** `origen-v2.2.0.zip`
- **Pack ID:** `ORIGEN`
- **Fixed for 26.1.2:**
  - `biome-provider-pipeline-v2` → `biome-provider-pipeline` (addon id in `pack.yml`)
  - `minecraft:chain` → `minecraft:iron_chain` (chain was split into per-material blocks)
  - `minecraft:grass` → `minecraft:short_grass`

### ReimagEND — 2.3.7 (fixed)
- **File:** `ReimagEND-v2.3.7.zip`
- **Pack ID:** `REIMAGEND`
- **Fixed for 26.1.2:** same changes as Origen (addon id, chain, grass).

### Tartarus — 0.0.2 Pre-Release (fixed)
- **File:** `Tartarus_v0.0.2_Pre-Release.zip`
- **Pack ID:** `TARTARUS`
- **Fixed for 26.1.2:** `minecraft:chain` → `minecraft:iron_chain`.

## Official packs

Overworld 2.0.0, ReimagEND 3.0.0 and Tartarus 1.0.0 (plus the default metapack) ship inside the
Terra jar itself and are unpacked automatically on first start — they are not duplicated here.
