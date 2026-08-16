<img align="left" width="64" height="64" src="https://raw.githubusercontent.com/wiki/PolyhedralDev/Terra/images/terra_logo.png" alt="Terra Logo">

# Terra — SkyXNetwork fork for Paper 26.1.2

A custom build of [Terra](https://github.com/PolyhedralDev/Terra), maintained by **SkyXNetwork** to keep
Terra running on our Paper 26.1.2 servers.

---

## ⚠️ Before anything else

**This fork is made for SkyXNetwork servers.** It is published so our team can rebuild and redeploy it
at any time, and so the config packs we use stay in sync with the plugin.

If you run this build anywhere else, you do so **entirely at your own risk**:
- it is based on unmerged, third-party code (see *Credits*),
- it may contain bugs that bite in environments we have not tested,
- SkyXNetwork provides **no support** for third-party setups and accepts **no responsibility** for any
  damage, instability or data loss caused by this plugin.

## Why this fork exists

Terra's official releases stopped a long time ago (the last one targets Bukkit 1.19) and upstream
development has stalled. Paper 26.1.2 ships a newer Minecraft block set (`iron_chain`, `short_grass`,
reworked registries, …) that old builds simply do not understand, which makes them refuse to start.

This fork bundles:

- **NMS bindings for Paper v26.1.2** (and v26.2) taken from ArikSquad's unmerged
  [PR #559](https://github.com/PolyhedralDev/Terra/pull/559), on top of the current Terra master;
- a fixed block-state fallback that no longer crashes on Paper's non-thread-safe `CraftBlockData`
  cache (`Invalid block state data: …` errors);
- a corrected NMS block-registry lookup (`reloadableRegistries` instead of the worldgen-only
  `registryAccess`);
- the usual Terra ecosystem, unchanged: addons, config packs, TerraScript, `/terra` commands.

## What's in this repository

| Path | Content |
| --- | --- |
| `/dist` | Ready-to-install Bukkit jar (the `-shaded` one is the file you want) |
| `/world-packs` | Config packs updated for the 26.1.2 block set |
| everything else | The full Terra source tree, with the fixes listed above |

## Installation

1. Stop your server.
2. Copy the latest `Terra-bukkit-*-shaded.jar` from `dist/` into your `plugins/` folder.
   Keep **one** Terra jar in `plugins/` — remove any older one.
3. Start the server once. Terra unpacks its addons and default packs into `plugins/Terra/`.
4. Stop the server, drop the packs you want (from `world-packs/`) into `plugins/Terra/packs/`,
   then start it again.
5. Create a world with the generator `Terra:<pack-id>` (e.g. `Terra:ORIGEN`) and check the console:
   you should see `Loading config pack "<id>"` followed by `Loaded config pack …` with no errors.

## Upgrading from an older dev build

Terra only replaces files it knows by name, so leftovers from an old install *will* break startup.
Before (or after) swapping the jar:

1. empty `plugins/Terra/addons/`,
2. in `plugins/Terra/packs/` keep only the zips you actually use (no leftover folders or old
   zip versions — the folder is scanned as-is, and duplicate pack IDs cause errors),
3. in `plugins/Terra/metapacks/` keep only `default.zip`.

When in doubt: delete the whole `plugins/Terra/` folder (back up any custom pack first) and let
Terra unpack everything again from the jar.

## Config packs (updated for 26.1.2)

| Pack | File | What was fixed |
| --- | --- | --- |
| Origen 2.2.0 | `world-packs/origen-v2.2.0.zip` | addon id `biome-provider-pipeline-v2` → `biome-provider-pipeline`, `chain` → `iron_chain`, `grass` → `short_grass` |
| ReimagEND 2.3.7 | `world-packs/ReimagEND-v2.3.7.zip` | same fixes (addon id, chain, grass) |
| Tartarus 0.0.2 Pre-Release | `world-packs/Tartarus_v0.0.2_Pre-Release.zip` | `chain` → `iron_chain` |

The official default packs (Overworld 2.0.0, ReimagEND 3.0.0, Tartarus 1.0.0 and the default
metapack) are bundled **inside the jar** and unpacked automatically — there is nothing to download
for them. Use the `world-packs/` files only when you want one of the custom versions above.

## Building

- Requires **JDK 25** and Gradle 9.5 (the wrapper is included).
- Windows: `gradlew.bat :platforms:bukkit:build`
- The jar ends up in `platforms/bukkit/build/libs/`; the `-shaded` one is deployable.

## Credits & licensing

- **Terra** — [PolyhedralDev](https://github.com/PolyhedralDev), licensed under MIT / GPLv3
  (see the `LICENSE` files in the tree).
- **Paper 26.1.2 support** — the unmerged [PR #559](https://github.com/PolyhedralDev/Terra/pull/559)
  by [ArikSquad](https://github.com/ArikSquad).
- **Fork fixes** (CraftBlockData fallback, registry lookup, pack updates) — SkyXNetwork.

This fork follows the same licenses as upstream Terra.
